package com.universalsompo.meta.metaapp.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {

    public static String getPathFromURI(Context mContext, Uri contentUri) throws Exception {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = mContext.getContentResolver().query(contentUri, proj, null, null, null);
        assert cursor != null;
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    private static Bitmap getPhoto(String photoPath) {
        Bitmap bitMap = null;
        ExifInterface ei = null;
        try {
            ei = new ExifInterface(photoPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_UNDEFINED);
        Bitmap myBitmap = BitmapFactory.decodeFile(photoPath);
        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                bitMap = rotateImage(myBitmap, 90);
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                bitMap = rotateImage(myBitmap, 180);
                break;
            case ExifInterface.ORIENTATION_ROTATE_270:
                bitMap = rotateImage(myBitmap, 270);
                break;
            case ExifInterface.ORIENTATION_NORMAL:
                bitMap = myBitmap;
                break;
            case ExifInterface.ORIENTATION_UNDEFINED:
                bitMap = myBitmap;
                break;
            default:
                bitMap = myBitmap;
                break;
        }
        return bitMap;
    }

    private static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix,
                true);
    }


    public static void viewFromGallery(Activity mContext) {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        mContext.startActivityForResult(Intent.createChooser(intent, "Select Picture"), RequestConstants.PIC_GALARY);
    }

    void captureImage(Activity mContext, String fileName) {
        File mImageFile = new File(Environment.getExternalStorageDirectory() + File.separator + "DCIM" + File.separator + fileName);
        Uri tempURI = Uri.fromFile(mImageFile);
        Intent photoCaptureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        photoCaptureIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempURI);
        mContext.startActivityForResult(photoCaptureIntent, RequestConstants.PIC_Camera);
    }

    public static boolean emailValidator(String  et) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(et);
        return matcher.matches();
    }

    public static String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }


    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }
}

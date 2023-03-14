package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model;

import java.io.File;

public class DocumentModel1 {
    public File getLink() {
        return Link;
    }

    public void setLink(File link) {
        Link = link;
    }

    File Link;

    public String getExtension() {
        return Extension;
    }

    public void setExtension(String extension) {
        Extension = extension;
    }

    String Extension;

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    String base64;
}

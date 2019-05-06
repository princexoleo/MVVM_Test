package com.leo.testingmvvm.models;

public class NicePlace {
    private String title ;
    private String ImageUri ;

    public NicePlace(String title, String imageUri) {
        this.title = title;
        ImageUri = imageUri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUri() {
        return ImageUri;
    }

    public void setImageUri(String imageUri) {
        ImageUri = imageUri;
    }
}

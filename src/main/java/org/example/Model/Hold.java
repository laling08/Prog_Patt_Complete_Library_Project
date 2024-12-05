package org.example.Model;

import java.time.LocalDateTime;

public class Hold {
    private int userId;
    private int mediaId;
    private LocalDateTime holdDate;

    public Hold(int userId, int mediaId, LocalDateTime holdDate) {
        this.userId = userId;
        this.mediaId = mediaId;
        this.holdDate = holdDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public LocalDateTime getHoldDate() {
        return holdDate;
    }

    public void setHoldDate(LocalDateTime holdDate) {
        this.holdDate = holdDate;
    }
}

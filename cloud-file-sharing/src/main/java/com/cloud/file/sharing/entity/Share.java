package com.cloud.file.sharing.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "share")
@IdClass(Share.PK.class)
@Data
public class Share {
    
    @EmbeddedId
    private Share.PK pk;
    
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "file_id", insertable = false, updatable = false)
    private File file;
    
    @Column(name = "shared_on", nullable = false)
    private LocalDate sharedOn;
    
    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    @IdClass
    public static class PK implements Serializable {
        @Id
        @Column(name = "user_id")
        private Long userId;
        
        @Id
        @Column(name = "file_id")
        private Long fileId;
        
        // No-arg constructor needed for JPA
        public PK() {}
        
        public PK(Long userId, Long fileId) {
            this.userId = userId;
            this.fileId = fileId;
        }
        
        // Getters and setters
        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
        public Long getFileId() { return fileId; }
        public void setFileId(Long fileId) { this.fileId = fileId; }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PK)) return false;
            PK pk = (PK) o;
            return Objects.equals(userId, pk.userId) &&
                   Objects.equals(fileId, pk.fileId);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(userId, fileId);
        }
    }
}

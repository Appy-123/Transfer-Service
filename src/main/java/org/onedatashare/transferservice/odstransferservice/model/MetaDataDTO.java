package org.onedatashare.transferservice.odstransferservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "job_info_3")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MetaDataDTO {
    @Id
    //Job ID
    private String id;
    //Source EndPoint
    private String source;
    //Destination EndPoint
    private String destination;
    //Type of the File
    private String type;
    //Transfer Speed
    private int speed;
    //What kind of optimization used
    private String optimizations;
    //Chunk Size during transfer
    private int chunks;
    //Total time to transfer
    private int time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getOptimizations() {
        return optimizations;
    }

    public void setOptimizations(String optimizations) {
        this.optimizations = optimizations;
    }

    public int getChunks() {
        return chunks;
    }

    public void setChunks(int chunks) {
        this.chunks = chunks;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

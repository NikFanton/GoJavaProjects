package products.components.specifications;

import products.components.memory.VideoMemory;

public class VideoCard {
    private VideoMemory videoMemory;
    public int numberOfCores;
    public double coreClockFrequency;

    public VideoMemory getVideoMemory() {
        return videoMemory;
    }

    public void setVideoMemory(VideoMemory videoMemory) {
        this.videoMemory = videoMemory;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public double getCoreClockFrequency() {
        return coreClockFrequency;
    }

    public void setCoreClockFrequency(double coreClockFrequency) {
        this.coreClockFrequency = coreClockFrequency;
    }
}

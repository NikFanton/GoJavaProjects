package products.components.specifications;

import products.components.memory.RAM;

public class ComputerTechSpecification extends SuperTechSpecification {

    private VideoCard videoCard;

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public ComputerTechSpecification(RAM ram, Processor processor, VideoCard videoCard) {
        super(ram, processor);
        this.videoCard = videoCard;
    }
}

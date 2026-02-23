package poo.interfaces_e_lambda.Aula1;

public class Smartphone implements VideoPlayer, MusicPlayer{
    @Override
    public void playMusic() {
        System.out.println("O smartphone tocando música");
    }

    @Override
    public void pauseMusic() {
        System.out.println("O smartphone pausando música");
    }

    @Override
    public void stopMusic() {
        System.out.println("O smartphone parando música");
    }

    @Override
    public void playVideo() {
        System.out.println("O smartphone reproduzindo o vídeo");
    }

    @Override
    public void pauseVideo() {
        System.out.println("O smartphone pausando o vídeo");
    }

    @Override
    public void stopVideo() {
        System.out.println("O smartphone parando o vídeo");
    }
}

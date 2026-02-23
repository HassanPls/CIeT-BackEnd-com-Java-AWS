package poo.interfaces_e_lambda.Aula1;

public class Computer implements VideoPlayer, MusicPlayer{
    @Override
    public void playMusic() {
        System.out.println("O computador tocando música");
    }

    @Override
    public void pauseMusic() {
        System.out.println("O computador pausando música");
    }

    @Override
    public void stopMusic() {
        System.out.println("O computador parando música");
    }

    @Override
    public void playVideo() {
        System.out.println("O computador reproduzindo o vídeo");
    }

    @Override
    public void pauseVideo() {
        System.out.println("O computador pausando o vídeo");
    }

    @Override
    public void stopVideo() {
        System.out.println("O computador parando o vídeo");
    }
}

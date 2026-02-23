package poo.interfaces_e_lambda.Aula1;

public class Aula1 {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer() {

            @Override
            public void playMusic() {
                System.out.println("Tocando a música");
            }

            @Override
            public void pauseMusic() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'pauseMusic'");
            }

            @Override
            public void stopMusic() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'stopMusic'");
            }
            
        };

        musicPlayer.playMusic();

        Computer musicPlayer2 = new Computer();
        runMusic(musicPlayer2);
        runVideo(musicPlayer2);
    }

    public static void runVideo(VideoPlayer videoPlayer) {
        videoPlayer.playVideo();
    }

    public static void runMusic(MusicPlayer musicPlayer) {
        musicPlayer.playMusic();
    }
}

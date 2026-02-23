package poo.interfaces_e_lambda.Aula1;

public record MusicBox(String music, boolean isPaused) implements MusicPlayer {

    @Override
    public void playMusic() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'playMusic'");
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
    
}

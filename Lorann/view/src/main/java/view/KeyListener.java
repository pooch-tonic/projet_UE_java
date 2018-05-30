package view;

import java.awt.event.KeyEvent;

class KeyListener implements java.awt.event.KeyListener {
    private IKeyEventPerformer keyEventPerformer;

    public KeyListener(final IKeyEventPerformer keyEventPerformer) {
        this.setKeyEventPerformer(keyEventPerformer);
    }

    @Override
    public void keyTyped(final KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(final KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(final KeyEvent e) {
        // TODO Auto-generated method stub

    }

    private IKeyEventPerformer getKeyEventPerformer() {
        return this.keyEventPerformer;
    }

    private void setKeyEventPerformer(
            final IKeyEventPerformer keyEventPerformer) {
        this.keyEventPerformer = keyEventPerformer;
    }
}

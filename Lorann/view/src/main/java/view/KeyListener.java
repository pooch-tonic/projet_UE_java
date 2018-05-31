package view;

import java.awt.event.KeyEvent;

/**
 * @author aurel
 *
 */
class KeyListener implements java.awt.event.KeyListener {
    /** The object able to perform keyboard events. */
    private IKeyEventPerformer keyEventPerformer;

    /**
     * Instantiates a new KeyListener
     *
     * @param keyEventPerformer
     */
    public KeyListener(final IKeyEventPerformer keyEventPerformer) {
        this.setKeyEventPerformer(keyEventPerformer);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent e) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent e) {
        // TODO Auto-generated method stub

    }

    /**
     * Gets the keyEventPerformer
     * 
     * @return the keyEventPerformer
     */
    private IKeyEventPerformer getKeyEventPerformer() {
        return this.keyEventPerformer;
    }

    /**
     * Sets the keyEventPerformer
     * 
     * @param keyEventPerformer
     */
    private void setKeyEventPerformer(
            final IKeyEventPerformer keyEventPerformer) {
        this.keyEventPerformer = keyEventPerformer;
    }

}

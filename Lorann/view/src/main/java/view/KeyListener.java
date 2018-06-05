/*
 *
 */
package view;

import java.awt.event.KeyEvent;

/**
 * <h1>The class KeyListener implements a KeyListner to be able to detect
 * keyboard inputs</h1>
 *
 * @author aurel
 * @version 31 mai 2018
 */
class KeyListener implements java.awt.event.KeyListener {
    /** The object able to perform keyboard events. */
    private IKeyEventPerformer keyEventPerformer;

    /**
     * Instantiates a new KeyListener
     *
     * @param keyEventPerformer
     */
    public KeyListener(final IKeyEventPerformer keyEventPerformer) throws Exception {
        if (keyEventPerformer == null) {
            throw new Exception("The KeyEventPerformer is null");
        }
        this.setKeyEventPerformer(keyEventPerformer);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent e) {
    }

    /*
     * (non-Javadoc)
     *
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        this.getKeyEventPerformer().performKeyPressedEvent(e);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent e) {
        this.getKeyEventPerformer().performKeyReleasedEvent(e);
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
    private void setKeyEventPerformer(final IKeyEventPerformer keyEventPerformer) {
        this.keyEventPerformer = keyEventPerformer;
    }

}

package view;

import java.awt.event.KeyEvent;

import controller.IOrderStacker;

class KeyEventPerformer implements IKeyEventPerformer {
    private IOrderStacker orderStacker;

    public KeyEventPerformer(final IOrderStacker orderStacker) {
        this.setOrderStacker(orderStacker);
    }

    @Override
    public void performEvent(final KeyEvent keyEvent) {
        // TODO Auto-generated method stub

    }

    private IOrderStacker getOrderStacker() {
        return this.orderStacker;
    }

    private void setOrderStacker(final IOrderStacker orderStacker) {
        this.orderStacker = orderStacker;
    }
}

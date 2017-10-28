//package touhou.players;
//
//import bases.GameObject;
//import touhou.inputs.InputManager;
//
//public class SphereCastSpell2 {
//    boolean spellDisabled;
//    final int COOL_DOWN_TIME = 5;
//    int coolDownCount;
//
//    public void run(Sphere2 owner) {
//        if (spellDisabled) {
//            coolDownCount++;
//            if (coolDownCount >= COOL_DOWN_TIME) {
//                spellDisabled = false;
//                coolDownCount = 0;
//            }
//            return;
//        }
//
//        if (InputManager.instance.jPressed) {
//            SphereSpell newSpell = GameObject.recycle(SphereSpell.class);
//            newSpell.position.set(owner.position.subtract(0, owner.image.getHeight() / 2));
//            spellDisabled = true;
//        }
//
//    }
//}

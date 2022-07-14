package Temp;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier{

        Corps corps;

        public SpecialisedSoldierImpl(int id, String firstName, String lastName) {
                super(id, firstName, lastName);
        }

        @Override
        public Corps getCorps() {
                return corps;
        }

        @Override
        public String toString(){
                return super.toString();
        }
}

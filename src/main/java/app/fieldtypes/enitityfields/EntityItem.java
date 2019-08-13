package app.fieldtypes.enitityfields;

import app.fieldtypes.Field;
import app.viewtypes.navigationviews.menuitems.Clickable;

public class EntityItem extends Field implements Clickable {


    public EntityItem() {
        super(title, xpath);
    }

    public void click(){};

    @Override
    public void type() {

    }
}

package app.fieldtypes.textfields;

import app.fieldtypes.Field;
import app.fieldtypes.Typable;
import app.viewtypes.navigationviews.menuitems.Clickable;

public class SingleLineText extends Field implements Clickable, Typable {


    SingleLineText(String title, String xpath){
        super(title, xpath);
    }


    public void click(){
        super.click();
    }

    public void type(String text){
        super.type(text);
    }



}

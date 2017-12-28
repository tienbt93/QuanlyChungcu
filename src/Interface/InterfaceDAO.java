package Interface;

import DbConnect.MyConnect;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PTIT
 */
public abstract class InterfaceDAO {
    public MyConnect myConnect;

    public InterfaceDAO() {
        myConnect=MyConnect.getInstance();
    }
    public abstract Object add(Object ob);
    public abstract Object delete(int id);
    public abstract Object getId(int id);
    public abstract Object update(Object ob);
    public abstract Object getAll();
}

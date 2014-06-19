package io.zhpooer.store.web.action;

import io.zhpooer.store.domain.Store;
import io.zhpooer.store.service.StoreService;

import java.util.List;

import javax.annotation.Resource;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class StoreAction extends ActionSupport implements ModelDriven<Store> {
    private final Logger LOG = Logger.getLogger(StoreAction.class);
    private Store store = new Store();

    @Resource(name = "storeService")
    private StoreService storeService;

    @Override
    public Store getModel() {
        return store;
    }

    public String add() {
        LOG.info("add" + store);
        storeService.addStore(store);
        return "listStore";
    }
    
    public String delete() {
        LOG.info("delete " + store);
        storeService.delStore(store);
        return "listStore";
    }

    public String list() {
        List<Store> stores = storeService.findAllStore();
        ActionContext.getContext().put("stores", stores);
        return "storeView"; // storeList.js
    }

    public String editView(){
        Store editStore = storeService.findStoreById(store.getId());
        ActionContext.getContext().getValueStack().push(editStore);
        return "editView";
    }
    
    public String ajaxList(){
        List<Store> stores = storeService.findAllStore();
        ActionContext.getContext().getValueStack().push(stores);
        return "jsonList";
    }
    
    // TODO 校验器
    public String update(){
        storeService.updateStore(store);
        return "listStore";
    }
}

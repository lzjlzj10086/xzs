package com.demo.menu.service;


import com.demo.menu.dao.MenuDao;
import com.demo.menu.entity.Menu;
import com.demo.menu.entity.MenuVo;
import com.demo.util.AppResponse;
import com.demo.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuService {

    @Resource
    private MenuDao menuDao;

    /**
     * 菜单添加
     * @param menu
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(Menu menu){
        int countmenu = menuDao.countMenu(menu);
        if(countmenu !=0){
            return AppResponse.bizError("该菜单已存在，请重新输入");
        }
        menu.setIsDelete(0);
        menu.setMenuCode(StringUtil.getCommonCode(2));
        int count = menuDao.addMenu(menu);
        if(count == 0){
            return AppResponse.bizError("添加菜单失败");
        }
        return AppResponse.success("添加菜单成功");
    }

    /**
     * 菜单列表查询
     * @param menu
     * @return
     */
    public AppResponse listMenu(Menu menu){
        List<MenuVo> listMenu= menuDao.listMenu(menu);
        return AppResponse.success("列表查询成功",listMenu);
    }

    /**
     * 菜单详情查询
     * @param menuCode
     * @return
     */
    public AppResponse findMenuById(String menuCode){
        Menu menu = menuDao.findMenuById(menuCode);
        return AppResponse.success("菜单详情查询成功",menu);
    }

    /**
     * 菜单修改
     * @param menu
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenu(Menu menu){
        int count = menuDao.updateMenu(menu);
        if(count == 0){
            return AppResponse.bizError("数据发生变化，请重新输入");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 菜单删除
     * @param menuCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu(String menuCode,String userId){
        int count = menuDao.deleteMenu(menuCode,userId);
        if(count == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");
    }
}

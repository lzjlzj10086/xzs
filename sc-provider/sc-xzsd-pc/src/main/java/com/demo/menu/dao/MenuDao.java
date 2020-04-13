package com.demo.menu.dao;

import com.demo.menu.entity.Menu;
import com.demo.menu.entity.MenuVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDao {

    /**
     * 判断是否存在改菜单
     * @param menu
     * @return
     */
    int countMenu(Menu menu);
    /**
     * 添加菜单
     * @param menu
     * @return
     */
    int addMenu(Menu menu);

    /**
     * 菜单列表查询
     * @param menu
     * @return
     */
    List<MenuVo> listMenu(Menu menu);

    List<MenuVo> listMenuTwo(Menu menu);
    /**
     * 菜单详情查询
     * @param menuCode
     * @return
     */
    Menu findMenuById(String menuCode);

    /**
     * 修改菜单
     * @param menu
     * @return
     */
    int updateMenu(Menu menu);

    /**
     * 删除菜单
     * @param menuCode
     * @return
     */
    int deleteMenu(String menuCode, String userId);
}

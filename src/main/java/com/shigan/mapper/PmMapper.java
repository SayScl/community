package com.shigan.mapper;

import com.shigan.pojo.pm.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
@Component
@Mapper
public interface PmMapper {
    //降序查询出所有报修
    public List<Wybx> getwybxbycommunityid(Integer community);

    //<!--增加新报修-->
    public int addbx(Wybx wybx);

     //<!--确认报修-->
   public int confirmbx(Wybx wybx);



        //<!--根据小区Id查小区公告-->
   public List<Xqgg> getggbycommunityid(Integer communityid);


    //根据公告id查看公告详细信息
    public Xqgg getgginfobyid(Integer id);


    //<!--根据小区Id查物业展示-->
    public List<Wyzs> getzsbycommunityid(Integer communityid);


    //根据公告id查看物业展示详细信息
    public Wyzs getzsinfobyid(Integer id);


    //<!--根据小区Id装修案例-->
    public List<Xfzx> getzxbycommunityid(Integer communityid);

     //<!--根据userid查找我的装修进度-->
    public List<Wdzx> getwdzx(Integer userid);


    //根据公告id查看装修案例详情
    public Xfzx getzxinfobyid(Integer id);

    //<!--修改装修案例热度-->
    public int upzxinfohot(Xfzx xfzx);


       //<!--插入充值-->
    public int addcz(Kjcz cz);


    //<!--查找本人成功充值记录-->
    public List<Kjcz> getczbyuserid(Integer userid);




    //<!--根据小区id查找投票-->
    public List<Xqtp> gettpbycommunityid(Integer communityid);


    //<!--根据id查找小区投票-->
    public Xqtp gettpbyid(Integer id);


    //<!--根据tid查找选项-->
    public List<Se> getsebytid(Integer tid);

     //<!--根据tid查找选项-->
    public Se getsebyid(Integer id);

     //<!--先改选项投票数-->
   public int upsebyid(Se se);

    //<!--根据用户id查投票-->
    public List<Usertp> gettpbyuserid(Integer userid);

   // <!--增加用户投票-->
    public int addusertp(Usertp usertp);

}

package com.imooc.service;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.pojo.vo.CommentLevelCountsVO;
import com.imooc.pojo.vo.ItemCommentVO;
import com.imooc.utils.PagedGridResult;

import java.util.List;

/**
 * @description:
 * @author: kb
 * @create: 2020-09-13 13:48
 **/
public interface ItemService {

    public Items queryItemById(String itemId);

    public List<ItemsImg> queryItemImgList(String itemId);

    public List<ItemsSpec> queryItemSpecList(String itemId);

    public ItemsParam queryItemParam(String itemId);

    public CommentLevelCountsVO queryCommentCounts(String itemId);

    public PagedGridResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);
}


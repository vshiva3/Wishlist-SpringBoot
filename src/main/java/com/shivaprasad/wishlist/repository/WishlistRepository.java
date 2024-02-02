package com.shivaprasad.wishlist.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shivaprasad.wishlist.pojo.WishList;

@Repository
public class WishlistRepository {
    
    private List<WishList> list = new ArrayList<>();

    public WishList getWishList(int index){
        return list.get(index);
    }

    public void addWishList(WishList wishList){
        list.add(wishList);
    }

    public void updateWishList(int index, WishList wishList){
        list.set(index, wishList);
    }

    public void removeWishList(WishList wishList){
        list.remove(wishList);
    }

    public List<WishList> getTotalList(){
        return list;
    }
}

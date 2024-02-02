package com.shivaprasad.wishlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivaprasad.wishlist.Constants;
import com.shivaprasad.wishlist.pojo.WishList;
import com.shivaprasad.wishlist.repository.WishlistRepository;


@Service
public class WishlistService {

    @Autowired
    WishlistRepository wishlistRepository;

    public WishList geWishList(int index){
        return wishlistRepository.getWishList(index);
    }

    public void addWishList(WishList wishList){
        wishlistRepository.addWishList(wishList);
    }

    public void updateWishList(int index, WishList wishList){
        wishlistRepository.updateWishList(index, wishList);
    }

    public void removeWishList(WishList wishList){
        wishlistRepository.removeWishList(wishList);
    }

    public String addToRepo(WishList wishList){
        int index = isTheItemAvailable(wishList.getId());
        String status = Constants.FAIL;
        if(index == Constants.NOT_FOUND){
            addWishList(wishList);
            status = Constants.SUCCESS;
        }
        else {
            updateWishList(index, wishList);
            status = Constants.UPDATE;
        }
        return status;
    }

    public int isTheItemAvailable(String id){
        for(int i=0;i<getTotalList().size();i++){
            if(getTotalList().get(i).getId().equals(id)){
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }


    public List<WishList> getTotalList(){
        return wishlistRepository.getTotalList();
    }

    public WishList putItemInModel(String id){
        int index = isTheItemAvailable(id);
        return index!=Constants.NOT_FOUND ? geWishList(index) : new WishList();
    }
}

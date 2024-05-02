package com.shivaprasad.wishlist;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.shivaprasad.wishlist.pojo.WishList;
import com.shivaprasad.wishlist.repository.WishlistRepository;
import com.shivaprasad.wishlist.service.WishlistService;

@RunWith(MockitoJUnitRunner.class)
public class WishlistServiceTest {
    
    @Mock
    WishlistRepository wishlistRepository;

    @InjectMocks
    WishlistService wishlistService;

    @Test
    public void isTheItemAvailableTest(){
        WishList wish = new WishList("Electronics", "Laptop", "70000", new Date());
        when(wishlistRepository.getTotalList()).thenReturn(Arrays.asList(wish));
        //when(wishlistRepository.getWishList(0)).thenReturn(wish);

        int index = wishlistService.isTheItemAvailable(wish.getId());
        int not = wishlistService.isTheItemAvailable("131");
        assertEquals(0, index);
        assertEquals(Constants.NOT_FOUND, not);
    }

    @Test
    public void putItemInModel(){
        WishList wish = new WishList("Electronics", "Laptop", "70000", new Date());
        when(wishlistRepository.getTotalList()).thenReturn(Arrays.asList(wish));
        when(wishlistRepository.getWishList(0)).thenReturn(wish);
        
        int index = wishlistService.isTheItemAvailable(wish.getId());
        WishList newOne = wishlistRepository.getWishList(index);
        assertEquals(wish, newOne);
    }
}


package com.ecommerce.auction_service;

import com.ecommerce.auction_service.Client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "ecommerce/auction/auctionUI")
public class AuctionControllerUI {

    private final UserClient userClient;

    @Autowired
    public AuctionControllerUI(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/auctionForwardPage")
    public String auctionForwardPage(@RequestParam int auctionid, @RequestParam int itemid, @CookieValue(value = "session_id", required = false) String existingSessionId) {
        boolean isValidSession = userClient.sessionChecker(existingSessionId);
        if(isValidSession){
            return "auctionForwardPage";
        }
        else{
            return "auctionSignOutPage";
        }
    }

    @GetMapping("/auctionDutchPage")
    public String auctionDutchPage(@RequestParam int auctionid, @RequestParam int itemid, @CookieValue(value = "session_id", required = false) String existingSessionId) {
        boolean isValidSession = userClient.sessionChecker(existingSessionId);
        if(isValidSession){
            return "auctionDutchPage";
        }
        else{
            return "auctionSignOutPage";
        }
    }

    @GetMapping("/auctionEndPage")
    public String auctionEndPage(@RequestParam int auctionid, @RequestParam int itemid, @RequestParam int userid,
                                 @CookieValue(value = "session_id", required = false) String existingSessionId) {
        boolean isValidSession = userClient.sessionChecker(existingSessionId);
        if(isValidSession){
            return "auctionEndPage";
        }
        else{
            return "auctionSignOutPage";
        }
    }

    @GetMapping("/auctionSignOutPage")
    public String auctionSignOutPage(@CookieValue(value = "session_id", required = false) String existingSessionId) {
        boolean isValidSession = userClient.sessionChecker(existingSessionId);
        if(isValidSession){
            return "auctionSignOutPage";
        }
        else{
            return "auctionSignOutPage";
        }
    }

}

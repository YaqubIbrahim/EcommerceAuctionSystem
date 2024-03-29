package com.ecommerce.catalog_service;

import com.ecommerce.payment_service.OtherServiceObjects.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "ecommerce/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService){
        this.catalogService = catalogService;
    }

    @PostMapping("/sell")
    public boolean sellOnCatalog(@RequestBody Catalog catalog, @RequestParam String sellerusername) {
       return catalogService.sellOnCatalog(catalog, sellerusername);
    }

    @GetMapping("/entirecatalog")
    @ResponseBody
    public List<Catalog> entireCatalog() {
        return catalogService.entireCatalog();
    }

    @GetMapping("/searchById")
    @ResponseBody
    public Catalog searchCatalogById(@RequestParam int id) {
        return catalogService.searchCatalogById(id);
    }

    @GetMapping("/searchByIdExpired")
    public Catalog searchCatalogFromIdExpired(@RequestParam int id){
        return catalogService.searchCatalogFromIdExpired(id);
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Catalog> searchCatalog(@RequestParam String itemname) {
        return catalogService.searchCatalog(itemname);
    }

    @GetMapping("/getAuctionFromCatalog")
    @ResponseBody
    public Auction getAuctionFromCatId(@RequestParam int auctioneditemid){
        return catalogService.getAuctionFromCatId(auctioneditemid);
    }

    @PutMapping("/setAsExpired")
    void setCatalogAsExpired(@RequestParam int id){
        catalogService.setItemAsExpired(id);
    }

    @DeleteMapping("/deleteitem")
    public void removeFromCatalogById(@RequestParam int id){
        catalogService.removeItem(id);
    }
}
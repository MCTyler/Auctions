package com.sainttx.auction.api;

import com.sainttx.auction.api.module.AuctionModule;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.UUID;

/**
 * Represents an Auction that players can bid on
 */
public interface Auction {

    /**
     * Gets the owner of this auction
     *
     * @return the auction creator
     */
    UUID getOwner();

    /**
     * Gets the {@link UUID} of the current top bidder for this auction
     *
     * @return the current {@link UUID} of the winner
     */
    UUID getTopBidder();

    /**
     * Gets the name of the current top bidder
     *
     * @return the top bidders name
     */
    String getTopBidderName();

    /**
     * Gets the item that is being auctioned
     *
     * @return the auctioned item
     */
    ItemStack getItem();

    /**
     * Gets the amount of time left in this auction
     *
     * @return amount of time left
     */
    int getTimeLeft();

    /**
     * Sets the amount of time left in this auction
     *
     * @param time new amount of time left
     */
    void setTimeLeft(int time);

    /**
     * Cancels this auction and returns the items to the owner
     */
    void cancel();

    /**
     * Ends the auction as if the timer ran out
     *
     * @param broadcast whether or not to broadcast any
     *                  information about this auction ending
     */
    void end(boolean broadcast);

    /**
     * Gets the amount required to automatically win this auction
     *
     * @return the auto win amount
     */
    double getAutowin();

    /**
     * Gets the lowest amount that can be bid on this auction
     *
     * @return the bid increment of this auction
     */
    double getBidIncrement();

    /**
     * Gets the percentage of money that will be removed from
     * the winning amount
     *
     * @return the tax percent of this auction
     */
    double getTax();

    /**
     * Gets the current top bid in this auction
     *
     * @return the top bid
     */
    double getTopBid();

    /**
     * Places a bid made by a player, does not handle
     * any economy functions. Specifying a null player will
     * make the server think the console/server is bidding
     *
     * @param player the player
     * @param bid    the amount bid by the player
     */
    void placeBid(@Nullable Player player, double bid);

    /**
     * Gets a deep copy of modules present in this auction
     *
     * @return all modules tied to the auction
     */
    Collection<AuctionModule> getModules();

    /**
     * Adds a module to this auction
     *
     * @param module the module
     */
    void addModule(AuctionModule module);

    /**
     * Removes a module from this auction. Returns whether a
     * module was actually removed or not.
     *
     * @param module the module
     * @return if a module was actually removed
     */
    boolean removeModule(AuctionModule module);

    /**
     * Represents an auctions timer
     */
    interface Timer extends Runnable {

    }

    /**
     * Represents an Auction builder
     */
    interface Builder {

        /**
         * Creates the auction
         *
         * @return the auction created by the builder
         */
        Auction build();
    }
}
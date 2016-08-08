package net.thedragonteam.armorplus.api.crafting.advarmorforge;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;

/**
 * sokratis12GR.ArmorPlus.api
 * ArmorPlus created by sokratis12GR on 6/20/2016 6:21 PM.
 */
public class InventoryCrafting implements IInventory {
    /**
     * List of the stacks in the crafting matrix.
     */
    private final ItemStack[] stackList;
    /**
     * the width of the crafting inventory
     */
    private final int inventoryWidth;
    private final int inventoryHeight;
    /**
     * Class containing the callbacks for the events on_GUIClosed and on_CraftMaxtrixChanged.
     */
    private final Container eventHandler;

    public InventoryCrafting(Container eventHandlerIn, int width, int height) {
        int i = width * height;
        this.stackList = new ItemStack[i];
        this.eventHandler = eventHandlerIn;
        this.inventoryWidth = width;
        this.inventoryHeight = height;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory() {
        return this.stackList.length;
    }

    /**
     * Returns the stack in the given slot.
     */
    @Nullable
    public ItemStack getStackInSlot(int index) {
        return index >= this.getSizeInventory() ? null : this.stackList[index];
    }

    /**
     * Gets the ItemStack in the slot specified.
     */
    @Nullable
    public ItemStack getStackInRowAndColumn(int row, int column) {
        return row >= 0 && row < this.inventoryWidth && column >= 0 && column <= this.inventoryHeight ? this.getStackInSlot(row + column * this.inventoryWidth) : null;
    }

    /**
     * Get the name of this object. For players this returns their username
     */
    public String getName() {
        return "container.crafting";
    }

    /**
     * Returns true if this thing is named
     */
    public boolean hasCustomName() {
        return false;
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     */
    public ITextComponent getDisplayName() {
        return (ITextComponent) (this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]));
    }

    /**
     * Removes a stack from the given slot and returns it.
     */
    @Nullable
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.stackList, index);
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    @Nullable
    public ItemStack decrStackSize(int index, int count) {
        ItemStack itemstack = ItemStackHelper.getAndSplit(this.stackList, index, count);

        if (itemstack != null) {
            this.eventHandler.onCraftMatrixChanged(this);
        }

        return itemstack;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
        this.stackList[index] = stack;
        this.eventHandler.onCraftMatrixChanged(this);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
     */
    public int getInventoryStackLimit() {
        return 64;
    }

    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    public void markDirty() {
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    public void openInventory(EntityPlayer player) {
    }

    public void closeInventory(EntityPlayer player) {
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    public int getField(int id) {
        return 0;
    }

    public void setField(int id, int value) {
    }

    public int getFieldCount() {
        return 0;
    }

    public void clear() {
        for (int i = 0; i < this.stackList.length; ++i) {
            this.stackList[i] = null;
        }
    }

    public int getHeight() {
        return this.inventoryHeight;
    }

    public int getWidth() {
        return this.inventoryWidth;
    }
}

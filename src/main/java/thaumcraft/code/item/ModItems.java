package thaumcraft.code.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import thaumcraft.code.Thaumcraft;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, Thaumcraft.MODID);

    public static final RegistryObject<Item> SALIS_MUNDUS = ITEMS.register("salis_mundus",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AMBER = ITEMS.register("amber",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> QUICKSILVER = ITEMS.register("quicksilver",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> THAUMOMETER = ITEMS.register("thaumometer",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> THAUMONOMICON = ITEMS.register("thaumonomicon",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> VIS_CRYSTAL = ITEMS.register("vis_crystal",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

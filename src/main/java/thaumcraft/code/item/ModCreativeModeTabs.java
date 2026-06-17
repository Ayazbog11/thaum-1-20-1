package thaumcraft.code.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import thaumcraft.code.Thaumcraft;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Thaumcraft.MODID);

    public static final RegistryObject<CreativeModeTab> THAUMCRAFT_TAB = CREATIVE_MODE_TABS.register("thaumcraft_tab",
            () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.SALIS_MUNDUS.get()))
            .title(Component.translatable("creativetab.thaumcraft_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.SALIS_MUNDUS.get());
                pOutput.accept(ModItems.VIS_CRYSTAL.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

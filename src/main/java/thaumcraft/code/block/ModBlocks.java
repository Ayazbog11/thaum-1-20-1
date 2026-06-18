package thaumcraft.code.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import thaumcraft.code.worldgen.tree.GreatwoodTreeGrower;
import thaumcraft.code.worldgen.tree.SilverwoodTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import thaumcraft.code.Thaumcraft;
import thaumcraft.code.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, Thaumcraft.MODID);

    public static final RegistryObject<Block> ARCANE_STONE = registerBlock("arcane_stone",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f, 10.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AMBER_ORE = registerBlock("amber_ore",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CINNABAR_ORE = registerBlock("cinnabar_ore",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GREATWOOD_LOG = registerBlock("greatwood_log",
        () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(2.0f)));

    public static final RegistryObject<Block> GREATWOOD_PLANKS = registerBlock("greatwood_planks",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0f, 3.0f)));

    public static final RegistryObject<Block> SILVERWOOD_LOG = registerBlock("silverwood_log",
        () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(2.0f)));

    public static final RegistryObject<Block> SILVERWOOD_PLANKS = registerBlock("silverwood_planks",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0f, 3.0f)));

    public static final RegistryObject<Block> GREATWOOD_LEAVES = registerBlock("greatwood_leaves",
        () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> GREATWOOD_SAPLING = registerBlock("greatwood_sapling",
        () -> new SaplingBlock(new GreatwoodTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> SILVERWOOD_SAPLING = registerBlock("silverwood_sapling",
        () -> new SaplingBlock(new SilverwoodTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> SILVERWOOD_LEAVES = registerBlock("silverwood_leaves",
        () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

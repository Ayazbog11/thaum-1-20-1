package thaumcraft.code.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import thaumcraft.code.Thaumcraft;
import thaumcraft.code.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMBER_ORE_KEY = registerKey("amber_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CINNABAR_ORE_KEY = registerKey("cinnabar_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> amberOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.AMBER_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> cinnabarOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.CINNABAR_ORE.get().defaultBlockState()));

        register(context, AMBER_ORE_KEY, Feature.ORE, new OreConfiguration(amberOres, 9)); // vein size 9
        register(context, CINNABAR_ORE_KEY, Feature.ORE, new OreConfiguration(cinnabarOres, 6)); // vein size 6
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Thaumcraft.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

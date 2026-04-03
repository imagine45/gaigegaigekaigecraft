package org.imgaine.gaigegaigekaigecraft.init;

import org.imgaine.gaigegaigekaigecraft.block.BlockGravelBlock;
import org.imgaine.gaigegaigekaigecraft.block.BlockRedBlock;
import org.imgaine.gaigegaigekaigecraft.block.BlockUniverseBlock;
import org.imgaine.gaigegaigekaigecraft.block.CoffinoftheIronmountain1Block;
import org.imgaine.gaigegaigekaigecraft.block.CoffinoftheIronmountain2Block;
import org.imgaine.gaigegaigekaigecraft.block.CursedBlockBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainBloodBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainBlueSkyBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainBoneBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainCloudBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainDarkStoneBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainFenceBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainFlowerBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainGrassBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainHoleBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainIceBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainPlanksBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainPodzolBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainSandBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainStoneBricksBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainWaterBlock;
import org.imgaine.gaigegaigekaigecraft.block.DomainWhiteBlock;
import org.imgaine.gaigegaigekaigecraft.block.InBarrierBlock;
import org.imgaine.gaigegaigekaigecraft.block.JujutsuBarrierBlock;
import org.imgaine.gaigegaigekaigecraft.block.SchoolBellBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JujutsucraftModBlocks {
   public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, "gaigegaigekaigecraft");
   public static final RegistryObject<Block> JUJUTSU_BARRIER = REGISTRY.register("jujutsu_barrier", JujutsuBarrierBlock::new);
   public static final RegistryObject<Block> COFFINOFTHE_IRONMOUNTAIN_1 = REGISTRY.register("coffinofthe_ironmountain_1", CoffinoftheIronmountain1Block::new);
   public static final RegistryObject<Block> COFFINOFTHE_IRONMOUNTAIN_2 = REGISTRY.register("coffinofthe_ironmountain_2", CoffinoftheIronmountain2Block::new);
   public static final RegistryObject<Block> BLOCK_GRAVEL = REGISTRY.register("block_gravel", BlockGravelBlock::new);
   public static final RegistryObject<Block> BLOCK_UNIVERSE = REGISTRY.register("block_universe", BlockUniverseBlock::new);
   public static final RegistryObject<Block> IN_BARRIER = REGISTRY.register("in_barrier", InBarrierBlock::new);
   public static final RegistryObject<Block> BLOCK_RED = REGISTRY.register("block_red", BlockRedBlock::new);
   public static final RegistryObject<Block> DOMAIN_GRASS = REGISTRY.register("domain_grass", DomainGrassBlock::new);
   public static final RegistryObject<Block> DOMAIN_SAND = REGISTRY.register("domain_sand", DomainSandBlock::new);
   public static final RegistryObject<Block> DOMAIN_WATER = REGISTRY.register("domain_water", DomainWaterBlock::new);
   public static final RegistryObject<Block> DOMAIN_BONE = REGISTRY.register("domain_bone", DomainBoneBlock::new);
   public static final RegistryObject<Block> SCHOOL_BELL = REGISTRY.register("school_bell", SchoolBellBlock::new);
   public static final RegistryObject<Block> DOMAIN_FLOWER = REGISTRY.register("domain_flower", DomainFlowerBlock::new);
   public static final RegistryObject<Block> DOMAIN_BLUE_SKY = REGISTRY.register("domain_blue_sky", DomainBlueSkyBlock::new);
   public static final RegistryObject<Block> DOMAIN_CLOUD = REGISTRY.register("domain_cloud", DomainCloudBlock::new);
   public static final RegistryObject<Block> DOMAIN_STONE_BRICKS = REGISTRY.register("domain_stone_bricks", DomainStoneBricksBlock::new);
   public static final RegistryObject<Block> CURSED_BLOCK = REGISTRY.register("cursed_block", CursedBlockBlock::new);
   public static final RegistryObject<Block> DOMAIN_ICE = REGISTRY.register("domain_ice", DomainIceBlock::new);
   public static final RegistryObject<Block> DOMAIN_BLOOD = REGISTRY.register("domain_blood", DomainBloodBlock::new);
   public static final RegistryObject<Block> DOMAIN_PLANKS = REGISTRY.register("domain_planks", DomainPlanksBlock::new);
   public static final RegistryObject<Block> DOMAIN_PODZOL = REGISTRY.register("domain_podzol", DomainPodzolBlock::new);
   public static final RegistryObject<Block> DOMAIN_WHITE = REGISTRY.register("domain_white", DomainWhiteBlock::new);
   public static final RegistryObject<Block> DOMAIN = REGISTRY.register("domain", DomainBlock::new);
   public static final RegistryObject<Block> DOMAIN_DARK_STONE = REGISTRY.register("domain_dark_stone", DomainDarkStoneBlock::new);
   public static final RegistryObject<Block> DOMAIN_FENCE = REGISTRY.register("domain_fence", DomainFenceBlock::new);
   public static final RegistryObject<Block> DOMAIN_HOLE = REGISTRY.register("domain_hole", DomainHoleBlock::new);

   public JujutsucraftModBlocks() {
   }

   /*static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, "gaigegaigekaigecraft");
      JUJUTSU_BARRIER = REGISTRY.register("jujutsu_barrier", JujutsuBarrierBlock::new);
      COFFINOFTHE_IRONMOUNTAIN_1 = REGISTRY.register("coffinofthe_ironmountain_1", CoffinoftheIronmountain1Block::new);
      COFFINOFTHE_IRONMOUNTAIN_2 = REGISTRY.register("coffinofthe_ironmountain_2", CoffinoftheIronmountain2Block::new);
      BLOCK_GRAVEL = REGISTRY.register("block_gravel", BlockGravelBlock::new);
      BLOCK_UNIVERSE = REGISTRY.register("block_universe", BlockUniverseBlock::new);
      IN_BARRIER = REGISTRY.register("in_barrier", InBarrierBlock::new);
      BLOCK_RED = REGISTRY.register("block_red", BlockRedBlock::new);
      DOMAIN_GRASS = REGISTRY.register("domain_grass", DomainGrassBlock::new);
      DOMAIN_SAND = REGISTRY.register("domain_sand", DomainSandBlock::new);
      DOMAIN_WATER = REGISTRY.register("domain_water", DomainWaterBlock::new);
      DOMAIN_BONE = REGISTRY.register("domain_bone", DomainBoneBlock::new);
      SCHOOL_BELL = REGISTRY.register("school_bell", SchoolBellBlock::new);
      DOMAIN_FLOWER = REGISTRY.register("domain_flower", DomainFlowerBlock::new);
      DOMAIN_BLUE_SKY = REGISTRY.register("domain_blue_sky", DomainBlueSkyBlock::new);
      DOMAIN_CLOUD = REGISTRY.register("domain_cloud", DomainCloudBlock::new);
      DOMAIN_STONE_BRICKS = REGISTRY.register("domain_stone_bricks", DomainStoneBricksBlock::new);
      CURSED_BLOCK = REGISTRY.register("cursed_block", CursedBlockBlock::new);
      DOMAIN_ICE = REGISTRY.register("domain_ice", DomainIceBlock::new);
      DOMAIN_BLOOD = REGISTRY.register("domain_blood", DomainBloodBlock::new);
      DOMAIN_PLANKS = REGISTRY.register("domain_planks", DomainPlanksBlock::new);
      DOMAIN_PODZOL = REGISTRY.register("domain_podzol", DomainPodzolBlock::new);
      DOMAIN_WHITE = REGISTRY.register("domain_white", DomainWhiteBlock::new);
      DOMAIN = REGISTRY.register("domain", DomainBlock::new);
      DOMAIN_DARK_STONE = REGISTRY.register("domain_dark_stone", DomainDarkStoneBlock::new);
      DOMAIN_FENCE = REGISTRY.register("domain_fence", DomainFenceBlock::new);
      DOMAIN_HOLE = REGISTRY.register("domain_hole", DomainHoleBlock::new);
   }*/

   @EventBusSubscriber(
      bus = Bus.MOD,
      value = {Dist.CLIENT}
   )
   public static class BlocksClientSideHandler {
      public BlocksClientSideHandler() {
      }

      @SubscribeEvent
      public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
         DomainGrassBlock.blockColorLoad(event);
         DomainPodzolBlock.blockColorLoad(event);
      }

      @SubscribeEvent
      public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
         DomainGrassBlock.itemColorLoad(event);
         DomainPodzolBlock.itemColorLoad(event);
      }
   }
}

package org.imgaine.gaigegaigekaigecraft.init;

import com.mojang.datafixers.types.Type;
import org.imgaine.gaigegaigekaigecraft.block.entity.BlockGravelBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.BlockRedBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.BlockUniverseBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.CoffinoftheIronmountain1BlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.CoffinoftheIronmountain2BlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.CursedBlockBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainBloodBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainBlueSkyBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainBoneBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainCloudBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainDarkStoneBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainFenceBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainFlowerBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainGrassBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainHoleBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainIceBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainPlanksBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainPodzolBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainSandBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainStoneBricksBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainWaterBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.DomainWhiteBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.InBarrierBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.JujutsuBarrierBlockEntity;
import org.imgaine.gaigegaigekaigecraft.block.entity.SchoolBellBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JujutsucraftModBlockEntities {
   public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "gaigegaigekaigecraft");
   public static final RegistryObject<BlockEntityType<?>> JUJUTSU_BARRIER = register("jujutsu_barrier", JujutsucraftModBlocks.JUJUTSU_BARRIER, JujutsuBarrierBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> COFFINOFTHE_IRONMOUNTAIN_1 = register("coffinofthe_ironmountain_1", JujutsucraftModBlocks.COFFINOFTHE_IRONMOUNTAIN_1, CoffinoftheIronmountain1BlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> COFFINOFTHE_IRONMOUNTAIN_2 = register("coffinofthe_ironmountain_2", JujutsucraftModBlocks.COFFINOFTHE_IRONMOUNTAIN_2, CoffinoftheIronmountain2BlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> BLOCK_GRAVEL = register("block_gravel", JujutsucraftModBlocks.BLOCK_GRAVEL, BlockGravelBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> BLOCK_UNIVERSE = register("block_universe", JujutsucraftModBlocks.BLOCK_UNIVERSE, BlockUniverseBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> IN_BARRIER = register("in_barrier", JujutsucraftModBlocks.IN_BARRIER, InBarrierBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> BLOCK_RED = register("block_red", JujutsucraftModBlocks.BLOCK_RED, BlockRedBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_GRASS = register("domain_grass", JujutsucraftModBlocks.DOMAIN_GRASS, DomainGrassBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_SAND = register("domain_sand", JujutsucraftModBlocks.DOMAIN_SAND, DomainSandBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_WATER = register("domain_water", JujutsucraftModBlocks.DOMAIN_WATER, DomainWaterBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_BONE = register("domain_bone", JujutsucraftModBlocks.DOMAIN_BONE, DomainBoneBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> SCHOOL_BELL = register("school_bell", JujutsucraftModBlocks.SCHOOL_BELL, SchoolBellBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_FLOWER = register("domain_flower", JujutsucraftModBlocks.DOMAIN_FLOWER, DomainFlowerBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_BLUE_SKY = register("domain_blue_sky", JujutsucraftModBlocks.DOMAIN_BLUE_SKY, DomainBlueSkyBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_CLOUD = register("domain_cloud", JujutsucraftModBlocks.DOMAIN_CLOUD, DomainCloudBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_STONE_BRICKS = register("domain_stone_bricks", JujutsucraftModBlocks.DOMAIN_STONE_BRICKS, DomainStoneBricksBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> CURSED_BLOCK = register("cursed_block", JujutsucraftModBlocks.CURSED_BLOCK, CursedBlockBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_ICE = register("domain_ice", JujutsucraftModBlocks.DOMAIN_ICE, DomainIceBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_BLOOD = register("domain_blood", JujutsucraftModBlocks.DOMAIN_BLOOD, DomainBloodBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_PLANKS = register("domain_planks", JujutsucraftModBlocks.DOMAIN_PLANKS, DomainPlanksBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_PODZOL = register("domain_podzol", JujutsucraftModBlocks.DOMAIN_PODZOL, DomainPodzolBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_WHITE = register("domain_white", JujutsucraftModBlocks.DOMAIN_WHITE, DomainWhiteBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN = register("domain", JujutsucraftModBlocks.DOMAIN, DomainBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_DARK_STONE = register("domain_dark_stone", JujutsucraftModBlocks.DOMAIN_DARK_STONE, DomainDarkStoneBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_FENCE = register("domain_fence", JujutsucraftModBlocks.DOMAIN_FENCE, DomainFenceBlockEntity::new);
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_HOLE = register("domain_hole", JujutsucraftModBlocks.DOMAIN_HOLE, DomainHoleBlockEntity::new);

   public JujutsucraftModBlockEntities() {
   }

   private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
      return REGISTRY.register(registryname, () -> Builder.of(supplier, block.get()).build(null));
   }

   /*static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "gaigegaigekaigecraft");
      JUJUTSU_BARRIER = register("jujutsu_barrier", JujutsucraftModBlocks.JUJUTSU_BARRIER, JujutsuBarrierBlockEntity::new);
      COFFINOFTHE_IRONMOUNTAIN_1 = register("coffinofthe_ironmountain_1", JujutsucraftModBlocks.COFFINOFTHE_IRONMOUNTAIN_1, CoffinoftheIronmountain1BlockEntity::new);
      COFFINOFTHE_IRONMOUNTAIN_2 = register("coffinofthe_ironmountain_2", JujutsucraftModBlocks.COFFINOFTHE_IRONMOUNTAIN_2, CoffinoftheIronmountain2BlockEntity::new);
      BLOCK_GRAVEL = register("block_gravel", JujutsucraftModBlocks.BLOCK_GRAVEL, BlockGravelBlockEntity::new);
      BLOCK_UNIVERSE = register("block_universe", JujutsucraftModBlocks.BLOCK_UNIVERSE, BlockUniverseBlockEntity::new);
      IN_BARRIER = register("in_barrier", JujutsucraftModBlocks.IN_BARRIER, InBarrierBlockEntity::new);
      BLOCK_RED = register("block_red", JujutsucraftModBlocks.BLOCK_RED, BlockRedBlockEntity::new);
      DOMAIN_GRASS = register("domain_grass", JujutsucraftModBlocks.DOMAIN_GRASS, DomainGrassBlockEntity::new);
      DOMAIN_SAND = register("domain_sand", JujutsucraftModBlocks.DOMAIN_SAND, DomainSandBlockEntity::new);
      DOMAIN_WATER = register("domain_water", JujutsucraftModBlocks.DOMAIN_WATER, DomainWaterBlockEntity::new);
      DOMAIN_BONE = register("domain_bone", JujutsucraftModBlocks.DOMAIN_BONE, DomainBoneBlockEntity::new);
      SCHOOL_BELL = register("school_bell", JujutsucraftModBlocks.SCHOOL_BELL, SchoolBellBlockEntity::new);
      DOMAIN_FLOWER = register("domain_flower", JujutsucraftModBlocks.DOMAIN_FLOWER, DomainFlowerBlockEntity::new);
      DOMAIN_BLUE_SKY = register("domain_blue_sky", JujutsucraftModBlocks.DOMAIN_BLUE_SKY, DomainBlueSkyBlockEntity::new);
      DOMAIN_CLOUD = register("domain_cloud", JujutsucraftModBlocks.DOMAIN_CLOUD, DomainCloudBlockEntity::new);
      DOMAIN_STONE_BRICKS = register("domain_stone_bricks", JujutsucraftModBlocks.DOMAIN_STONE_BRICKS, DomainStoneBricksBlockEntity::new);
      CURSED_BLOCK = register("cursed_block", JujutsucraftModBlocks.CURSED_BLOCK, CursedBlockBlockEntity::new);
      DOMAIN_ICE = register("domain_ice", JujutsucraftModBlocks.DOMAIN_ICE, DomainIceBlockEntity::new);
      DOMAIN_BLOOD = register("domain_blood", JujutsucraftModBlocks.DOMAIN_BLOOD, DomainBloodBlockEntity::new);
      DOMAIN_PLANKS = register("domain_planks", JujutsucraftModBlocks.DOMAIN_PLANKS, DomainPlanksBlockEntity::new);
      DOMAIN_PODZOL = register("domain_podzol", JujutsucraftModBlocks.DOMAIN_PODZOL, DomainPodzolBlockEntity::new);
      DOMAIN_WHITE = register("domain_white", JujutsucraftModBlocks.DOMAIN_WHITE, DomainWhiteBlockEntity::new);
      DOMAIN = register("domain", JujutsucraftModBlocks.DOMAIN, DomainBlockEntity::new);
      DOMAIN_DARK_STONE = register("domain_dark_stone", JujutsucraftModBlocks.DOMAIN_DARK_STONE, DomainDarkStoneBlockEntity::new);
      DOMAIN_FENCE = register("domain_fence", JujutsucraftModBlocks.DOMAIN_FENCE, DomainFenceBlockEntity::new);
      DOMAIN_HOLE = register("domain_hole", JujutsucraftModBlocks.DOMAIN_HOLE, DomainHoleBlockEntity::new);
   }*/
}

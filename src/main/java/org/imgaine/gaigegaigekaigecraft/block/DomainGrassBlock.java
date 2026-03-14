package org.imgaine.gaigegaigekaigecraft.block;

import org.imgaine.gaigegaigekaigecraft.block.entity.DomainGrassBlockEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.IPlantable;

public class DomainGrassBlock extends Block implements EntityBlock {
   public DomainGrassBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_56739_).m_60913_(-1.0F, 9999.0F).m_278166_(PushReaction.BLOCK).m_60982_((bs, br, bp) -> true).m_60991_((bs, br, bp) -> true));
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, IPlantable plantable) {
      return true;
   }

   public MenuProvider m_7246_(BlockState state, Level worldIn, BlockPos pos) {
      BlockEntity tileEntity = worldIn.m_7702_(pos);
      MenuProvider var10000;
      if (tileEntity instanceof MenuProvider menuProvider) {
         var10000 = menuProvider;
      } else {
         var10000 = null;
      }

      return var10000;
   }

   public BlockEntity m_142194_(BlockPos pos, BlockState state) {
      return new DomainGrassBlockEntity(pos, state);
   }

   public boolean m_8133_(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.m_8133_(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.m_7702_(pos);
      return blockEntity == null ? false : blockEntity.m_7531_(eventID, eventParam);
   }

   @OnlyIn(Dist.CLIENT)
   public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
      event.getBlockColors().m_92589_((bs, world, pos, index) -> world != null && pos != null ? BiomeColors.m_108793_(world, pos) : GrassColor.m_46415_(0.5, 1.0), new Block[]{(Block)JujutsucraftModBlocks.DOMAIN_GRASS.get()});
   }

   @OnlyIn(Dist.CLIENT)
   public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
      event.getItemColors().m_92689_((stack, index) -> GrassColor.m_46415_(0.5, 1.0), new ItemLike[]{(ItemLike)JujutsucraftModBlocks.DOMAIN_GRASS.get()});
   }
}

package org.imgaine.gaigegaigekaigecraft.block;

import org.imgaine.gaigegaigekaigecraft.block.entity.DomainFenceBlockEntity;
import org.imgaine.gaigegaigekaigecraft.procedures.CanPassThroughBarriersProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;

public class DomainFenceBlock extends FenceBlock implements EntityBlock {
   public DomainFenceBlock() {
      super(Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(-1.0F, 9999.0F).pushReaction(PushReaction.BLOCK).forceSolidOn().isSuffocating((bs, br, bp) -> false).isViewBlocking((bs, br, bp) -> false));
   }

   public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, IPlantable plantable) {
      return true;
   }

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      BlockEntity tileEntity = worldIn.getBlockEntity(pos);
      MenuProvider var10000;
      if (tileEntity instanceof MenuProvider menuProvider) {
         var10000 = menuProvider;
      } else {
         var10000 = null;
      }

      return var10000;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new DomainFenceBlockEntity(pos, state);
   }

   public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.triggerEvent(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
   }

   public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
      if (context instanceof EntityCollisionContext entityContext) {
         Entity entity = entityContext.getEntity();
         if (CanPassThroughBarriersProcedure.execute(entity)) {
            if (entity.getY() > (double)pos.getY() + 0.9) {
               return super.getCollisionShape(state, level, pos, context);
            }

            return Shapes.empty();
         }
      }

      return super.getCollisionShape(state, level, pos, context);
   }
}

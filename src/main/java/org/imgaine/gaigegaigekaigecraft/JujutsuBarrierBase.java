package org.imgaine.gaigegaigekaigecraft;

import org.imgaine.gaigegaigekaigecraft.procedures.CanPassThroughBarriersProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class JujutsuBarrierBase extends Block {
   public JujutsuBarrierBase(BlockBehaviour.Properties properties) {
      super(properties);
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

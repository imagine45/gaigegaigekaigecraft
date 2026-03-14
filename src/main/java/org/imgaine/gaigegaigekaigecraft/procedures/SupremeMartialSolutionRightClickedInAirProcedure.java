package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.ThunderImpactEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SupremeMartialSolutionRightClickedInAirProcedure {
   public SupremeMartialSolutionRightClickedInAirProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         ItemStack item_a = ItemStack.f_41583_;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double x_pos = 0.0;
         double dis = 0.0;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            item_a = var10000.m_41777_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               item_a = var10000.m_41777_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.OFF_HAND, true);
               }
            }
         }

         if (item_a.m_41720_() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get()) {
            label97: {
               if (entity instanceof Player) {
                  Player _plr = (Player)entity;
                  if (_plr.m_150110_().f_35937_) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_36335_().m_41524_(item_a.m_41720_(), 20);
                     }
                     break label97;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_36335_().m_41524_(item_a.m_41720_(), 200);
               }
            }

            dis = 0.0;

            for(int index0 = 0; index0 < 32; ++index0) {
               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
               logic_a = false;
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(Math.min(4.0 + dis, 16.0) / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     logic_a = true;
                     x_pos = (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123341_();
                     y_pos = (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123342_();
                     z_pos = (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123343_();
                     break;
                  }
               }

               if (logic_a) {
                  break;
               }

               dis += 2.0;
            }

            x_pos += (Math.random() - 0.5) * 0.1;
            y_pos += (Math.random() - 0.5) * 0.1;
            z_pos += (Math.random() - 0.5) * 0.1;
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.THUNDER_IMPACT.get()).m_262496_(_level, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               }
            }

            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entityiterator instanceof ThunderImpactEntity && entityiterator.getPersistentData().m_128459_("NameRanged_ranged") == 0.0) {
                  SetRangedAmmoProcedure.execute(entity, entityiterator);
                  break;
               }
            }
         }

      }
   }
}

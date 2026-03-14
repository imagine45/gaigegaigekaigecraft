package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AttackGreatSerpentProcedure {
   public AttackGreatSerpentProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double entity_size = 0.0;
         double picth = 0.0;
         double yaw = 0.0;
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         entity.f_19789_ = 0.0F;
         if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
            entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
            entity.m_6021_(x, y - 0.5 * entity_size, z);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(x, y - 0.5 * entity_size, z, entity.m_146908_(), entity.m_146909_());
            }

            y_pos = y + (double)entity.m_20206_();

            for(int index0 = 0; index0 < 32; ++index0) {
               if (!world.m_8055_(BlockPos.m_274561_(x, y_pos + 1.0, z)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x, y_pos, z)).m_60815_()) {
                  world.m_46796_(2001, BlockPos.m_274561_(x, y_pos + 0.5, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y_pos, z))));
                  break;
               }

               --y_pos;
            }

            if (world.m_8055_(BlockPos.m_274561_(x, y + (double)entity.m_20206_() + 2.0, z)).m_60815_() || y < 0.0) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  x_pos = ((Entity)var10000).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  y_pos = ((Entity)var10000).m_20186_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  z_pos = ((Entity)var10000).m_20189_();
               } else {
                  x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(16.0 * entity_size)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
                  y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(16.0 * entity_size)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
                  z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(16.0 * entity_size)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
               }

               for(int index1 = 0; index1 < 128; ++index1) {
                  if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                     y_pos -= 12.0 * entity_size;
                     break;
                  }

                  y_pos -= 1.0 * entity_size;
               }

               entity.m_6021_(x_pos, y_pos, z_pos);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
               }

               entity.getPersistentData().m_128347_("cnt2", 1.0);
            }
         } else {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt1") < 3.0) {
               entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               y_pos = y;

               for(int index2 = 0; index2 < 32; ++index2) {
                  if (!world.m_8055_(BlockPos.m_274561_(x, y_pos + 1.0, z)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x, y_pos, z)).m_60815_()) {
                     world.m_46796_(2001, BlockPos.m_274561_(x, y_pos + 0.5, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y_pos, z))));
                     break;
                  }

                  ++y_pos;
               }
            } else if (entity.getPersistentData().m_128459_("cnt1") < 45.0) {
               entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               if (entity.getPersistentData().m_128459_("cnt1") < 14.0) {
                  if (entity.getPersistentData().m_128459_("cnt1") < 12.0) {
                     if (world.m_8055_(BlockPos.m_274561_(x, y + (double)entity.m_20206_() + 0.25, z)).m_60815_()) {
                        entity.m_6021_(x, y + 1.5 * entity_size, z);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(x, y + 1.5 * entity_size, z, entity.m_146908_(), entity.m_146909_());
                        }
                     } else {
                        entity.m_20256_(new Vec3(0.0, 1.5, 0.0));
                     }
                  }

                  y_pos = y;

                  for(int index3 = 0; index3 < 32; ++index3) {
                     if (!world.m_8055_(BlockPos.m_274561_(x, y_pos + 1.0, z)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x, y_pos, z)).m_60815_()) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, x, y_pos, z, 0.0F, ExplosionInteraction.NONE);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123796_, x, y_pos, z, (int)(10.0 * entity_size), 0.5 * entity_size, 0.5 * entity_size, 0.5 * entity_size, 0.5);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123813_, x, y_pos, z, (int)(10.0 * entity_size), 0.5 * entity_size, 0.5 * entity_size, 0.5 * entity_size, 0.5);
                        }

                        world.m_46796_(2001, BlockPos.m_274561_(x, y_pos + 0.5, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y_pos, z))));
                        break;
                     }

                     --y_pos;
                  }
               }

               Vec3 _center = new Vec3(x, y + (double)entity.m_20206_(), z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(3.0 * entity_size / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && entityiterator instanceof Player && !entityiterator.m_20159_()) {
                     entityiterator.m_20329_(entity);
                     entity.getPersistentData().m_128347_("cnt3", 1.0);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
                  entity.getPersistentData().m_128347_("knockback", 1.0);
               } else {
                  entity.getPersistentData().m_128347_("cnt3", 0.0);
               }

               entity.getPersistentData().m_128347_("Damage", 10.0);
               entity.getPersistentData().m_128347_("Range", 3.0 * entity_size);
               entity.getPersistentData().m_128347_("effect", 1.0);
               entity.getPersistentData().m_128379_("swing", true);
               entity.getPersistentData().m_128379_("attack", true);
               RangeAttackProcedure.execute(world, x, y + (double)entity.m_20206_(), z, entity);
            } else {
               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt3") > 10.0) {
                  Vec3 _center = new Vec3(x, y + (double)entity.m_20206_(), z);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(3.0 * entity_size / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (entityiterator.m_20202_() == entity) {
                        logic_a = true;
                        entityiterator.m_20260_(true);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt3") > 20.0 && !logic_a) {
                     entity.getPersistentData().m_128347_("skill", 0.0);
                  }
               }
            }
         }

         entity.getPersistentData().m_128347_("Damage", 0.0);
      }
   }
}

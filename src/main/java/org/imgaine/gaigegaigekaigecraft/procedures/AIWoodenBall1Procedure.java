package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.WoodenBall1Entity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIWoodenBall1Procedure {
   public AIWoodenBall1Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_target = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double move_power = 0.0;
         double dis = 0.0;
         double tick = 0.0;
         double z_fix = 0.0;
         double num1 = 0.0;
         double x_fix = 0.0;
         double y_fix = 0.0;
         double old_distance = 0.0;
         double distance = 0.0;
         double num2 = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         dis = (double)(entity.m_20205_() * 2.0F);
         if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
            entity.getPersistentData().m_128347_("cnt2", 1.0);
            entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_());
            entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_());
            entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
            entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_pos") + entity.m_20154_().f_82479_);
            entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_pos") + entity.m_20154_().f_82480_);
            entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_pos") + entity.m_20154_().f_82481_);
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                  public Entity apply(LevelAccessor levelAccessor, String uuid) {
                     if (levelAccessor instanceof ServerLevel serverLevel) {
                        try {
                           return serverLevel.m_8791_(UUID.fromString(uuid));
                        } catch (Exception var5) {
                        }
                     }

                     return null;
                  }
               }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                  LivingEntity var10000;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     x_pos = ((Entity)var10000).m_20185_();
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     double var99 = ((Entity)var10000).m_20186_();
                     LivingEntity var10001;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var99 + (double)((Entity)var10001).m_20206_() * 0.5;
                     LivingEntity var100;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var100 = _mobEnt.m_5448_();
                     } else {
                        var100 = null;
                     }

                     z_pos = ((Entity)var100).m_20189_();
                  } else {
                     x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                     y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                     z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                  }

                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("x_pos", x_pos);
                  entity.getPersistentData().m_128347_("y_pos", y_pos);
                  entity.getPersistentData().m_128347_("z_pos", z_pos);
                  entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_pos") + entity.m_20154_().f_82479_);
                  entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_pos") + entity.m_20154_().f_82480_);
                  entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_pos") + entity.m_20154_().f_82481_);
               }
            }

            logic_a = false;
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
            z_pos = entity.m_20189_();
            x_power = entity.m_20154_().f_82479_ * 4.0;
            y_power = entity.m_20154_().f_82480_ * 4.0;
            z_power = entity.m_20154_().f_82481_ * 4.0;

            for(int index0 = 0; index0 < 10; ++index0) {
               x_pos += x_power;
               y_pos += y_power;
               z_pos += z_power;
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(5.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     logic_a = true;
                     num1 = Math.toRadians(Math.random() * 720.0);
                     num2 = (double)entityiterator.m_20205_() * 0.5 + dis * 4.0;
                     x_fix = Math.sin(num1) * num2;
                     y_fix = (double)(entityiterator.m_20206_() + 2.0F) * Math.random() + 1.0;
                     z_fix = Math.cos(num1) * num2;
                     entity.getPersistentData().m_128347_("x_pos", entityiterator.m_20185_() + x_fix);
                     entity.getPersistentData().m_128347_("y_pos", entityiterator.m_20186_() + y_fix);
                     entity.getPersistentData().m_128347_("z_pos", entityiterator.m_20189_() + z_fix);
                     entity.getPersistentData().m_128347_("x_power", entityiterator.m_20185_());
                     entity.getPersistentData().m_128347_("y_power", entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5);
                     entity.getPersistentData().m_128347_("z_power", entityiterator.m_20189_());
                     break;
                  }
               }

               if (logic_a) {
                  break;
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") == 1.0) {
            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            x_power = entity.m_20154_().f_82479_ * 1.0;
            y_power = entity.m_20154_().f_82480_ * 1.0;
            z_power = entity.m_20154_().f_82481_ * 1.0;
            old_distance = 9999.0;

            for(int index1 = 0; index1 < 3; ++index1) {
               distance = Math.sqrt(Math.pow(entity.m_20185_() - x_pos, 2.0) + Math.pow(entity.m_20186_() - y_pos, 2.0) + Math.pow(entity.m_20189_() - z_pos, 2.0));
               if (distance > old_distance || distance < dis) {
                  entity.getPersistentData().m_128347_("cnt2", 2.0);
                  entity.getPersistentData().m_128347_("cnt_bullet_hit", 15.0);
                  BulletDomainHit2Procedure.execute(world, entity);
                  break;
               }

               entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
               }

               old_distance = distance;
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") > 1.0) {
            RotateEntityProcedure.execute(entity.getPersistentData().m_128459_("x_power"), entity.getPersistentData().m_128459_("y_power"), entity.getPersistentData().m_128459_("z_power"), entity);
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt2") > 10.0) {
               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt3") <= 8.0) {
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
                  z_pos = entity.m_20189_();
                  if (entity.getPersistentData().m_128459_("cnt3") == 1.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo_wood.break")), SoundSource.NEUTRAL, 0.5F, 1.5F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo_wood.break")), SoundSource.NEUTRAL, 0.5F, 1.5F, false);
                        }
                     }

                     if (entity instanceof WoodenBall1Entity) {
                        ((WoodenBall1Entity)entity).setAnimation("empty");
                     }

                     if (entity instanceof WoodenBall1Entity) {
                        ((WoodenBall1Entity)entity).setAnimation("attack");
                     }
                  }

                  x_power = entity.m_20154_().f_82479_ * dis;
                  y_power = entity.m_20154_().f_82480_ * dis;
                  z_power = entity.m_20154_().f_82481_ * dis;

                  for(int index2 = 0; index2 < (int)entity.getPersistentData().m_128459_("cnt3"); ++index2) {
                     x_pos += x_power;
                     y_pos += y_power;
                     z_pos += z_power;
                  }

                  entity.getPersistentData().m_128347_("Damage", 12.0);
                  entity.getPersistentData().m_128347_("Range", dis * 2.0);
                  entity.getPersistentData().m_128347_("knockback", 0.5);
                  entity.getPersistentData().m_128347_("projectile_type", 1.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                     entity.getPersistentData().m_128347_("BlockRange", dis);
                     entity.getPersistentData().m_128347_("BlockDamage", 2.0);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt3") > 20.0) {
                  entity.getPersistentData().m_128347_("move", 0.0);
                  if (entity.getPersistentData().m_128459_("position_pitch") == 0.0 && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                  }
               }
            }
         }

      }
   }
}

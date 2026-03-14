package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AISlashProcedure {
   public AISlashProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a;
         double num1;
         double var10000;
         label230: {
            Entity entity_a = null;
            boolean logic_attack = false;
            boolean skull = false;
            boolean flame = false;
            boolean granite = false;
            boolean energy_wave = false;
            logic_a = false;
            boolean vertical = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double dis = 0.0;
            double z_power = 0.0;
            double y_power = 0.0;
            double x_power = 0.0;
            double speed = 0.0;
            double CNT6 = 0.0;
            double speed2 = 0.0;
            double range_fix = 0.0;
            double distance = 0.0;
            double d = 0.0;
            double range2 = 0.0;
            double z_center = 0.0;
            double range = 0.0;
            double y_center = 0.0;
            double yaw = 0.0;
            double x_center = 0.0;
            num1 = 0.0;
            double pitch = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity0 = (LivingEntity)entity;
               if (_livingEntity0.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  var10000 = _livingEntity0.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                  break label230;
               }
            }

            var10000 = 0.0;
         }

         if (var10000 < entity.getPersistentData().m_128459_("size") && entity instanceof LivingEntity) {
            LivingEntity _livingEntity4 = (LivingEntity)entity;
            if (_livingEntity4.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
               double var10001;
               label221: {
                  var93 = _livingEntity4.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get());
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity2 = (LivingEntity)entity;
                     if (_livingEntity2.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var10001 = _livingEntity2.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                        break label221;
                     }
                  }

                  var10001 = 0.0;
               }

               var93.m_22100_(Math.min(var10001 + 0.5, entity.getPersistentData().m_128459_("size")));
            }
         }

         double var59 = entity.m_20185_();
         double var60 = entity.m_20186_();
         double var61 = entity.m_20189_();
         double var66 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         double var72 = ReturnEntitySizeProcedure.execute(entity);
         double var69 = Math.max(1.0, Math.sqrt(var72));
         (new BiFunction<LevelAccessor, String, Entity>() {
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
         boolean var58 = GetEntityAnimationProcedure.execute(entity).contains("vertical");
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         double var65;
         if (entity.getPersistentData().m_128471_("Stop")) {
            entity.getPersistentData().m_128379_("Stop", false);
            logic_a = true;
            var65 = 0.0;
         } else {
            var65 = 2.0;
         }

         for(int index0 = 0; index0 < (int)(6.0 * var72); ++index0) {
            ParticleGeneratorCircleProcedure.execute(world, 1.0, (double)entity.m_146909_(), 0.0 * var72, Mth.m_216263_(RandomSource.m_216327_(), 0.5, 1.0) * var72, 4.0, entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * var72, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5 + entity.getPersistentData().m_128459_("y_power") * var72, entity.m_20186_() + (double)entity.m_20206_() * 0.5, (double)entity.m_146908_(), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * var72, entity.m_20189_(), "crit");
         }

         double var64 = entity.getPersistentData().m_128459_("x_power") * var65;
         double var63 = entity.getPersistentData().m_128459_("y_power") * var65;
         double var62 = entity.getPersistentData().m_128459_("z_power") * var65;
         entity.m_20256_(new Vec3(var64, var63, var62));
         if (entity.getPersistentData().m_128459_("cnt6") > 0.0) {
            entity.getPersistentData().m_128347_("x_knockback", var64 * 0.2);
            entity.getPersistentData().m_128347_("y_knockback", var63 * 0.2);
            entity.getPersistentData().m_128347_("z_knockback", var62 * 0.2);
         }

         double var67 = Math.sqrt(var64 * var64 + var63 * var63 + var62 * var62);
         if (var67 > 1.0) {
            var64 /= var67;
            var63 /= var67;
            var62 /= var67;
         }

         for(int index1 = 0; index1 < (int)Math.max(var67, 1.0); ++index1) {
            var59 = entity.m_20185_();
            var60 = entity.m_20186_();
            var61 = entity.m_20189_();
            ++num1;
            if (num1 > 0.0) {
               num1 = -1.5 * var72 + 1.0;
               double var75;
               double var79;
               if (var58) {
                  var75 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  var79 = Math.toRadians((double)(entity.m_146909_() + 90.0F));
               } else {
                  var75 = Math.toRadians((double)(entity.m_146908_() + 0.0F));
                  var79 = Math.toRadians(0.0);
               }

               var67 = -1.5 * var72;

               for(int index2 = 0; index2 < 3; ++index2) {
                  double var77 = var59 + Math.cos(var75) * Math.cos(var79) * var67;
                  double var73 = var60 + Math.sin(var79) * -1.0 * var67;
                  double var70 = var61 + Math.sin(var75) * Math.cos(var79) * var67;
                  entity.getPersistentData().m_128347_("Damage", 12.0 * var66);
                  entity.getPersistentData().m_128347_("Range", 4.0 * var72);
                  entity.getPersistentData().m_128347_("knockback", 0.5);
                  entity.getPersistentData().m_128347_("effect", 1.0);
                  RangeAttackProcedure.execute(world, var77, var73, var70, entity);
                  if (!logic_a) {
                     Vec3 _center = new Vec3(var77, var73, var70);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_a = true;
                           break;
                        }
                     }
                  }

                  var67 += 1.5 * var72;
               }
            }

            entity.m_6021_(entity.m_20185_() + var64 * 1.0, entity.m_20186_(), entity.m_20189_());
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + var64 * 1.0, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
            }

            if (entity.m_5830_() && ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var58)) {
               logic_a = true;
            }

            entity.m_6021_(entity.m_20185_(), entity.m_20186_() + var63 * 1.0, entity.m_20189_());
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + var63 * 1.0, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
            }

            if (entity.m_5830_() && ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var58)) {
               entity.m_6021_(entity.m_20185_(), entity.m_20186_() - var63 * 1.0, entity.m_20189_());
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() - var63 * 1.0, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
               }

               logic_a = true;
            }

            entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + var62 * 1.0);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + var62 * 1.0, entity.m_146908_(), entity.m_146909_());
            }

            if (entity.m_5830_() && ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var58)) {
               logic_a = true;
            }

            if (logic_a || ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var58)) {
               double var68 = Math.sqrt(entity.getPersistentData().m_128459_("Damage"));
               double var76;
               double var80;
               if (var58) {
                  var76 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  var80 = Math.toRadians((double)(entity.m_146909_() + 90.0F));
               } else {
                  var76 = Math.toRadians((double)(entity.m_146908_() + 0.0F));
                  var80 = Math.toRadians(0.0);
               }

               var67 = (double)Math.round(Math.max(2.0 * var69, 1.0) * -2.0);

               for(int index3 = 0; index3 < (int)Math.round(Math.max(2.0 * var69, 1.0) * 4.0 + 1.0); ++index3) {
                  double var78 = var59 + Math.cos(var76) * Math.cos(var80) * var67;
                  double var74 = var60 + Math.sin(var80) * -1.0 * var67;
                  double var71 = var61 + Math.sin(var76) * Math.cos(var80) * var67;

                  for(int index4 = 0; index4 < (int)Math.max(Math.round(entity.getPersistentData().m_128459_("cnt6") + 1.0), 1L); ++index4) {
                     entity.getPersistentData().m_128347_("BlockRange", Math.max(1.0 * var69, 1.0));
                     entity.getPersistentData().m_128347_("BlockDamage", 1.0 + var68 * 0.5);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                     BlockDestroyAllDirectionProcedure.execute(world, var78, var74, var71, entity);
                     entity.getPersistentData().m_128379_("noEffect", true);
                  }

                  ++var67;
               }
            }

            if (entity.m_5830_() && ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var58)) {
               logic_a = true;
            } else {
               logic_a = false;
            }
         }

         entity.getPersistentData().m_128379_("noEffect", false);
         if (logic_a || !entity.m_6084_() || var65 == 0.0) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") - 1.0);
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(var59, var60, var61), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(1.0 * var72), (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8, 1.0));
               } else {
                  _level.m_7785_(var59, var60, var61, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(1.0 * var72), (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8, 1.0), false);
               }
            }

            for(int index5 = 0; index5 < (int)(8.0 * var72); ++index5) {
               ParticleGeneratorSweepingEffectProcedure.execute(world, 1.0, var58 ? 0.0 : 180.0, (double)entity.m_146909_() + (var58 ? 180.0 * Mth.m_216263_(RandomSource.m_216327_(), -0.5, 0.5) : 0.0), 0.5 * var72, 2.0 * var72, 0.0, 1.0, var59, var59, var60, var60, (double)entity.m_146908_(), var61, var61, "minecraft:crit");
            }
         }

         if ((entity.getPersistentData().m_128459_("cnt1") > 10.0 + Math.min(Math.max(entity.getPersistentData().m_128459_("cnt6"), 0.0), 5.0) || entity.getPersistentData().m_128459_("cnt2") > Math.max(Math.min(entity.getPersistentData().m_128459_("cnt6") + 5.0, 15.0), 1.0)) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
         }

      }
   }
}

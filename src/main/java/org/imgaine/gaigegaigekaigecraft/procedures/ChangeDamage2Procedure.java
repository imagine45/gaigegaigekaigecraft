package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.TakabaFumihikoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;

public class ChangeDamage2Procedure {
   public ChangeDamage2Procedure() {
   }

   public static double execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double damage;
         int var10000;
         label110: {
            damage = 0.0;
            Entity entity_a = null;
            damage = 1.0;
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).m_19564_();
                  break label110;
               }
            }

            var10000 = 0;
         }

         if (var10000 > 0) {
            label104: {
               if (entityiterator instanceof Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 17.0 && ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 17.0) {
                     break label104;
                  }
               } else if (!(entityiterator instanceof TakabaFumihikoEntity)) {
                  break label104;
               }

               if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo_no_move")))) {
                  ItemStack var18;
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entityiterator;
                     var18 = _livEnt.m_21205_();
                  } else {
                     var18 = ItemStack.f_41583_;
                  }

                  if (var18.m_41720_() == JujutsucraftModItems.HARISEN.get()) {
                     label116: {
                        if (entityiterator instanceof Player) {
                           label92: {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt8 = (LivingEntity)entityiterator;
                                 if (_livEnt8.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                    break label92;
                                 }
                              }

                              if (!entityiterator.getPersistentData().m_128471_("attack")) {
                                 break label116;
                              }
                           }
                        }

                        if (entityiterator.getPersistentData().m_128459_("friend_num") == 0.0) {
                           entityiterator.getPersistentData().m_128347_("friend_num", Math.random());
                        }

                        if (entityiterator.getPersistentData().m_128459_("NameRanged") == 0.0) {
                           entityiterator.getPersistentData().m_128347_("NameRanged", Math.random());
                        }

                        entity.getPersistentData().m_128359_("OWNER_UUID", entityiterator.m_20149_());
                        entity.getPersistentData().m_128347_("friend_num", entityiterator.getPersistentData().m_128459_("friend_num"));
                        entity.getPersistentData().m_128347_("NameRanged_ranged", entityiterator.getPersistentData().m_128459_("NameRanged"));
                        entity.getPersistentData().m_128347_("x_power", entityiterator.m_20154_().f_82479_ * 6.0);
                        entity.getPersistentData().m_128347_("y_power", entityiterator.m_20154_().f_82480_ * 6.0);
                        entity.getPersistentData().m_128347_("z_power", entityiterator.m_20154_().f_82481_ * 6.0);
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 10, 9, false, false));
                           }
                        }

                        entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power"), entity.getPersistentData().m_128459_("y_power"), entity.getPersistentData().m_128459_("z_power")));
                        entity.m_146922_(entityiterator.m_146908_());
                        entity.m_146926_(entityiterator.m_146909_());
                        entity.m_5618_(entity.m_146908_());
                        entity.m_5616_(entity.m_146908_());
                        entity.f_19859_ = entity.m_146908_();
                        entity.f_19860_ = entity.m_146909_();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:critical")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                           } else {
                              _level.m_7785_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:critical")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                           }
                        }

                        if (!(entityiterator instanceof GeoEntity) && entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livingEntity40 = (LivingEntity)entityiterator;
                           if (_livingEntity40.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                              _livingEntity40.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-5.0);
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livingEntity41 = (LivingEntity)entityiterator;
                           if (_livingEntity41.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                              _livingEntity41.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                           }
                        }

                        PlayAnimationProcedure.execute(world, entityiterator);
                        damage = 0.0;
                     }
                  }
               }
            }
         }

         if (!entity.getPersistentData().m_128471_("attack")) {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt43 = (LivingEntity)entityiterator;
               if (_livEnt43.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                  damage *= 0.75;
               }
            }

            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt44 = (LivingEntity)entityiterator;
               if (_livEnt44.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                  damage *= 0.9;
               }
            }
         }

         return damage;
      } else {
         return 0.0;
      }
   }
}

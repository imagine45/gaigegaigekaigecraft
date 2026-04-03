package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade13Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade16Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade21Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade22Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade23Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade25Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade26Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade27Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade28Entity;
import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;

public class SetTagCursedSpritProcedure {
   public SetTagCursedSpritProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double NUM1 = 0.0;
         double size = 0.0;
         SetTagProcedure.execute(world, entity);
         entity.getPersistentData().putBoolean("CursedSpirit", true);
         if (entity instanceof CursedSpiritGrade16Entity && !entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {Silent:1b}");
         }

         if (entity instanceof CursedSpiritGrade21Entity || entity instanceof CursedSpiritGrade22Entity || entity instanceof CursedSpiritGrade23Entity || entity instanceof CursedSpiritGrade25Entity || entity instanceof CursedSpiritGrade26Entity || entity instanceof CursedSpiritGrade27Entity || entity instanceof CursedSpiritGrade28Entity || entity instanceof CursedSpiritGrade13Entity) {
            entity.setMaxUpStep(entity.getStepHeight() * 2.0F);
         }

         if ((entity instanceof RikaEntity || entity instanceof Rika2Entity) && entity instanceof LivingEntity) {
            LivingEntity _livingEntity15 = (LivingEntity)entity;
            if (_livingEntity15.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
               _livingEntity15.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(2.5);
            }
         }

      }
   }
}

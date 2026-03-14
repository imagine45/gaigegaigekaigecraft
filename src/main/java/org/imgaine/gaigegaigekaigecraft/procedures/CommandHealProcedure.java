package org.imgaine.gaigegaigekaigecraft.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class CommandHealProcedure {
   public CommandHealProcedure() {
   }

   public static void execute(CommandContext<CommandSourceStack> arguments) {
      try {
         for(Entity entityiterator : EntityArgument.m_91461_(arguments, "target")) {
            if (entityiterator instanceof LivingEntity _entity) {
               float var10001;
               if (entityiterator instanceof LivingEntity _livEnt) {
                  var10001 = _livEnt.m_21223_();
               } else {
                  var10001 = -1.0F;
               }

               _entity.m_21153_((float)((double)var10001 + DoubleArgumentType.getDouble(arguments, "amount")));
            }
         }
      } catch (CommandSyntaxException e) {
         e.printStackTrace();
      }

   }
}

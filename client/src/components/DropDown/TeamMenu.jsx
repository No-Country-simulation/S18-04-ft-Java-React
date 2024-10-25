'use client';
import Image from 'next/image';
import React, { useState } from 'react';
import { cn } from '@/lib/utils';
import * as DropdownMenu from '@radix-ui/react-dropdown-menu';
import DownChevron from '/public/images/svg/ChevronDown.svg';
import UpChevron from '/public/images/svg/ChevronUpColor.svg';

export const TeamMenu = () => {
  const [dropped, setDropped] = useState(false);

  return (
    <section className="mx-auto mt-8 flex w-full max-w-[90%] justify-between gap-x-3 text-xs leading-[14px] text-white">
      <DropdownMenu.Root onOpenChange={() => setDropped(!dropped)}>
        <DropdownMenu.Trigger asChild>
          <button
            className={cn(
              'inline-flex h-9 w-full items-center justify-between rounded-md px-5 text-xl font-medium',
              dropped ? 'bg-[#f5f4fb] text-[#320064]' : 'bg-[#320064]'
            )}
            aria-label="Team">
            S18-04-ft-Java-React
            <Image
              className="right-3 justify-end"
              width={18}
              height={18}
              src={dropped ? UpChevron : DownChevron}
              alt=""
            />
          </button>
        </DropdownMenu.Trigger>

        <DropdownMenu.Portal>
          <DropdownMenu.Content
            className="min-w-[--radix-dropdown-menu-trigger-width] rounded-md bg-[#063963] shadow-[0px_10px_38px_-10px_rgba(22,_23,_24,_0.35),_0px_10px_20px_-15px_rgba(22,_23,_24,_0.2)] will-change-[opacity,transform] data-[side=bottom]:animate-slideUpAndFade data-[side=left]:animate-slideRightAndFade data-[side=right]:animate-slideLeftAndFade data-[side=top]:animate-slideDownAndFade"
            sideOffset={5}>
            <DropdownMenu.Item className="grid grid-cols-2 border border-[#15b6d4] py-2 pl-5 leading-5">
              <div className="">Ramiro Brites</div>
              <div className="pl-3">UI/UX</div>
            </DropdownMenu.Item>

            <DropdownMenu.Separator className="m-1" />

            <DropdownMenu.Item className="grid grid-cols-2 border border-[#15b6d4] py-2 pl-5 leading-5">
              <div className="">Sofia Gonzales</div>
              <div className="pl-3">FrontEnd</div>
            </DropdownMenu.Item>

            <DropdownMenu.Separator className="m-1" />

            <DropdownMenu.Item className="grid grid-cols-2 border border-[#15b6d4] py-2 pl-5 leading-5">
              <div className="">Marria Escobar</div>
              <div className="pl-3">FrontEnd</div>
            </DropdownMenu.Item>

            <DropdownMenu.Separator className="m-1" />

            <DropdownMenu.Item className="grid grid-cols-2 border border-[#15b6d4] py-2 pl-5 leading-5">
              <div className="">Gonzalo Aguirre</div>
              <div className="pl-3">BackEnd</div>
            </DropdownMenu.Item>

            <DropdownMenu.Separator className="m-1" />

            <DropdownMenu.Item className="grid grid-cols-2 border border-[#15b6d4] py-2 pl-5 leading-5">
              <div className="">Oscar Perez</div>
              <div className="pl-3">BackEnd</div>
            </DropdownMenu.Item>

            <DropdownMenu.Separator className="m-1" />

            <DropdownMenu.Item className="grid grid-cols-2 border border-[#15b6d4] py-2 pl-5 leading-5">
              <div className="">Julio Escobar</div>
              <div className="pl-3">Tester QA</div>
            </DropdownMenu.Item>

            <DropdownMenu.Separator className="m-1" />

            <DropdownMenu.Item className="grid grid-cols-2 border border-[#15b6d4] py-2 pl-5 leading-5">
              <div className="">Victoria Molina</div>
              <div className="pl-3">Team Leader</div>
            </DropdownMenu.Item>
          </DropdownMenu.Content>
        </DropdownMenu.Portal>
      </DropdownMenu.Root>
    </section>
  );
};

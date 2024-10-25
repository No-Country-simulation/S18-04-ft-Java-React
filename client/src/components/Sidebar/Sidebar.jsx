'use client';
import Image from 'next/image';
import Link from 'next/link';
import React from 'react';
import { navItems } from '@/constants/navItems';

function Sidebar({ isOpen, onToggle }) {
  return (
    <div
      className={`flex flex-col items-center transition-all duration-300 ${isOpen ? 'w-64' : 'w-20'}`}>
      <div
        className="mt-10 flex cursor-pointer flex-row items-center justify-center"
        onClick={onToggle}>
        <Image
          className="mr-5"
          src="/images/noCountryLogo.png"
          alt="No Country logo"
          width={15.28}
          height={12.63}
        />
        <Image src="/images/noCountry.png" alt="No Country" width={82} height={16} />
      </div>

      <nav className="mt-14">
        <ul className="space-y-2">
          {navItems.map(({ href, label, icon }) => (
            <li key={href} className="flex items-center">
              <Link
                href={href}
                className={`flex items-center space-x-2 p-2 font-bold transition-all duration-300 hover:text-gradient-custom ${
                  isOpen ? 'w-full justify-start' : 'w-full justify-center'
                }`}>
                <Image src={icon} alt={`${label} icon`} width={20} height={20} />
                {isOpen && <span className="text-xs font-normal leading-5">{label}</span>}
              </Link>
            </li>
          ))}
        </ul>
      </nav>
    </div>
  );
}

export default Sidebar;

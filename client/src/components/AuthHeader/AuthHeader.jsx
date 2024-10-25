'use client';

import Image from 'next/image';
import defaultProfile from '/public/images/defaultProfile.png';
import noCountryLogo from '/public/images/noCountryLogo.png';
import Bell from '/public/images/Bell.png';
import Link from 'next/link';
import { useState } from 'react';
import Sidebar from '../Sidebar/Sidebar';

export const AuthHeader = () => {
  const [isSidebarOpen, setIsSidebarOpen] = useState(false);

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  return (
    <header className="mx-auto flex w-full max-w-3xl items-center justify-between px-5 pt-6">
      <div className="w-fit">
        <Image
          src={defaultProfile}
          width={35}
          height={35}
          className="aspect-square cursor-pointer rounded-full object-cover object-center"
          alt="profile image"
          onClick={toggleSidebar}
        />
      </div>
      <Link href="/home" className="h-full w-fit">
        <Image
          src={noCountryLogo}
          alt="No Country logo"
          width={35}
          height={35}
          className="aspect-square object-cover object-center"
        />
      </Link>
      <div className="h-full w-fit">
        <Image
          src={Bell}
          alt="Alert image"
          width={23}
          height={28}
          className="aspect-square object-center"
        />
      </div>

      {isSidebarOpen && (
        <>
          <div
            className={`fixed inset-0 z-40 bg-black transition-opacity duration-300 ease-in-out ${isSidebarOpen ? 'opacity-50' : 'pointer-events-none opacity-0'}`}
            onClick={toggleSidebar}></div>
          <div
            className={`fixed left-0 top-0 z-50 h-full w-64 bg-primary-400 text-white transition-transform duration-300 ease-in-out${isSidebarOpen ? 'translate-x-0' : '-traslate-x-full'}`}>
            <Sidebar isOpen={isSidebarOpen} onToggle={toggleSidebar} />
          </div>
        </>
      )}
    </header>
  );
};

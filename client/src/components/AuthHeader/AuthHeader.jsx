import Image from 'next/image';
import defaultProfile from '/public/images/defaultProfile.png';
import noCountryLogo from '/public/images/noCountryLogo.png';
import Bell from '/public/images/Bell.png';
import Link from 'next/link';

export const AuthHeader = () => {
  return (
    <header className="mx-auto flex w-full max-w-3xl items-center justify-between px-5 pt-6">
      <div className="w-fit">
        <Image
          src={defaultProfile}
          width={35}
          height={35}
          className="aspect-square rounded-full object-cover object-center"
          alt="profile image"
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
    </header>
  );
};

import Image from 'next/image';
import Link from 'next/link';
import Meet from '/public/images/svg/Meet.svg';

export const Meeting = () => {
  return (
    <div className="p-4">
      <div className="flex place-content-center">
        <Image width={30} height={30} src={Meet} alt="meet" />
        <Link href="" className="ml-2 font-medium text-white underline">
          Link al Meet
        </Link>
      </div>
    </div>
  );
};
